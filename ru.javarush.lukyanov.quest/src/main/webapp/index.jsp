<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="static/main.css" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <script src="<c:url value="/static/main.js"/>"></script>
    <script type="text/javascript">
        $(window).on('load', function () {
            $('#myModal').modal('show');
        });
    </script>
    <title>Driving Quest &#X1f6a8; &#X1f6a8; &#X1f6a8; &#X1f6a8; &#X1f6a7;</title>
    <link rel="shortcut icon" href="/static/img/favicon.png">
</head>
<body>
<div id="myModal" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Электромобиль &nbsp; - &nbsp; WIKIPEDIA</h5>
            </div>
            <div class="modal-body text-center">
                <p>Электромобиль — автомобиль, приводимый в движение одним или несколькими электродвигателями с питанием от независимого источника электроэнергии (аккумуляторов, топливных элементов, конденсаторов и т. п.), а не двигателем внутреннего сгорания. Электромобиль следует отличать от автомобилей с двигателем внутреннего сгорания и электрической передачей, а также от троллейбусов и трамваев.</p>
            </div>
        </div>
    </div>
</div>
<div class="p-3 mb-2 bg-primary text-white"><p class="text-center fs-2 text-decoration-underline">DRIVING ELECTRIC CARS
    QUEST</p></div>
<nav class="navbar" style="background-color: lightsteelblue">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="/static/img/electrocar.jpg" alt="Logo" width="450" height="300"
                 class="d-inline-block align-text-center">
        </a>
        <img src="/static/img/electrocar2.jpg" alt="Logo" width="450" height="300"
             class="d-inline-block align-text-center">
    </div>
</nav>
<hr>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<div class="survey-container">
    <div class="survey-container__options hide">
        <div class="survey-container__header"></div>
        <hr>
        <br>
        <div>
            <input type="radio" id="optionA" name="option" value="">
            <label for="optionA"></label>
        </div>
        <br>
        <div>
            <input type="radio" id="optionB" name="option" value="">
            <label for="optionB"></label>
        </div>
        <br>
        <hr>
    </div>
    <div class="survey-container__result-message"></div>
    <hr>
    <div class="survey-container__button">
        <c:if test="${progress != true}">
            <button id="start" class="button button_start" onclick="onGameStart()">Газ в пол! 🚀</button>
        </c:if>
        <button id="submit" class="button button_submit hide" onclick="onSubmit()">Вперед! ✔</button>
        <button id="reset" class="button button_reset hide" onclick="onReset()">Пройти квест ещё раз 💥</button>
    </div>
</div>
<hr>
<div class="games-counter">Количество поездок: <span class="games-counter__value">${gamesCounter}</span></div>
<div class="progress hide">${progress}</div>
</body>
</html>
