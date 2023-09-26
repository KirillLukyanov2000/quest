package ru.javarush.lukyanov.quest.servlets;


import ru.javarush.lukyanov.quest.model.QuestConfiguration;
import ru.javarush.lukyanov.quest.model.TeslaQuestConfiguration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);

        if (!activeGameSession(currentSession)) {
            QuestConfiguration questConfiguration = new TeslaQuestConfiguration();
            questConfiguration.setQuestLevelConfig();

            currentSession.setAttribute("stepsConfig", questConfiguration.getQuestLevelConfig());
            currentSession.setAttribute("currStepId", questConfiguration.getInitialLevelId());

            Object gamesCounter = currentSession.getAttribute("gamesCounter");
            if (gamesCounter == null) {
                currentSession.setAttribute("gamesCounter", 1);
            }
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private boolean activeGameSession(HttpSession currentSession) {
        if (currentSession == null) {
            return false;
        }

        Object progressSession = currentSession.getAttribute("progress");
        if (progressSession == null) {
            return false;
        }
        return (boolean) progressSession;
    }
}