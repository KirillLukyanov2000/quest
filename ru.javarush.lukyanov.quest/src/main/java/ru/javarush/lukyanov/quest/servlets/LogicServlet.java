package ru.javarush.lukyanov.quest.servlets;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.javarush.lukyanov.quest.model.AnswerConfiguration;
import ru.javarush.lukyanov.quest.model.entity.Answer;
import ru.javarush.lukyanov.quest.model.entity.Question;
import ru.javarush.lukyanov.quest.model.QuestLogic;

@WebServlet(name = "LogicServlet", value = "/play")
public class LogicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession(true);

        currentSession.setAttribute("progress", true);
        QuestLogic currQuestLogic = getCurrStep(req);
        Question question = new Question(currQuestLogic.getDescription(), currQuestLogic.getOptions());
        sendJson(question, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String answerOptionId = req.getParameter("answerOptionId");

        HttpSession currentSession = req.getSession();
        QuestLogic currQuestLogic = getCurrStep(req);
        AnswerConfiguration answerConfiguration = currQuestLogic.getAnswerOptionById(Integer.parseInt(answerOptionId));
        Answer answerResult;

        if (answerConfiguration.isTrueAnswer()) {
            int nextStepId = currQuestLogic.getNextStepId();
            currentSession.setAttribute("currStepId", nextStepId);
            if (nextStepId != 0) {
                answerResult = new Answer(true, nextStepId, null);
            } else {
                String victoryMessage = "Отличная поездка! Теперь самое время отдохнуть и посмотреть достопримечательности! \uD83C\uDF06\uD83C\uDFA0\uD83C\uDF66";
                answerResult = new Answer(true, nextStepId, victoryMessage);
            }
        } else {
            answerResult = new Answer(false, 0, answerConfiguration.getFailMessage());
        }
        sendJson(answerResult, resp);
    }

    private void sendJson(Object data, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF8");
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        Gson gson = new GsonBuilder().create();
        gson.toJson(data, writer);
    }

    private QuestLogic getCurrStep(HttpServletRequest req) {
        HttpSession currentSession = req.getSession();

        HashMap<Integer, QuestLogic> stepsConfig = (HashMap<Integer, QuestLogic>) currentSession.getAttribute("stepsConfig");
        int currStepId = (Integer) currentSession.getAttribute("currStepId");
        return stepsConfig.get(currStepId);
    }
}