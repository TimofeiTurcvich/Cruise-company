<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${applicationScope['lang']}" scope="session"/>
<fmt:setBundle basename="messages"/>
<html lang="en">
    <head>
        <link rel="stylesheet" href="profile.css">
        <meta charset="utf-8">
        <script src="profile.js" charset="utf-8"></script>
        <title></title>
    </head>
    <body>
        <div class="menu-bar">
            <div class="check">
                <a href="needToAccept">
                    <div class="option">
                        <fmt:message key="label.acceptTickets"/>
                    </div>
                </a>
            </div>

            <div class="check">
                <a href="sales">
                    <div class="option">
                        <fmt:message key="label.sales"/>
                    </div>
                </a>
            </div>
            <div class="check">
                <a href="tickets">
                    <div class="option">
                        <fmt:message key="label.voyages"/>
                    </div>
                </a>
            </div>
            <div class="check">
                <a href="newCruiseGeneral">
                    <div class="option">
                        <fmt:message key="label.newVoyage"/>
                    </div>
                </a>
            </div>
            <div class="check">
                <a href="../profile">
                    <div class="option">
                        <fmt:message key="label.profile"/>
                    </div>
                </a>
            </div>
        </div>
        <img src="../Hand-drawn-cruise-ship-on-transparent-background-PNG.png" alt="ship" width="1900" height="1000"
             class="ship"/>
        <div class="profile-options">
            <div class="test">
                <div class="selected">
                    <a href="profile.jsp">
                        <fmt:message key="label.changePass"/>
                    </a>
                </div>
            </div>
            <div class="test">
                <div class="profile-option">
                    <a href="quit">
                        <fmt:message key="label.quit"/>
                    </a>
                </div>
            </div>
        </div>
        <div class="profile-details">
            <div class="form">
                <form name="myForm" action="profile.html" method="post" onsubmit="return validateForm()">
                    <div class="user">
                        <input type="password" name="" required="">
                        <label>
                            <fmt:message key="label.oldPass"/>
                        </label>
                    </div>
                    <div class="user">
                        <input type="password" name="" required="">
                        <label>
                            <fmt:message key="label.newPass"/>
                        </label>
                    </div>
                    <div class="user">
                        <input type="password" name="" required="">
                        <label>
                            <fmt:message key="label.confirm"/>
                        </label>
                    </div>
                    <input type="submit" name="" value=<fmt:message key="label.submitButton"/>>
                </form>
            </div>
        </div>
        <div class="button-bar">
            <div class="check">
                <a href="changeLang?lang=en&page=${pageContext.request.getRequestURI()}">
                    <div class="option">
                        en
                    </div>
                </a>
            </div>
            <div class="check">
                <a href="changeLang?lang=uk&page=${pageContext.request.getRequestURI()}">
                    <div class="option">
                        uk
                    </div>
                </a>
            </div>
            <div class="check">
                <a href="changeLang?lang=ru&page=${pageContext.request.getRequestURI()}">
                    <div class="option">
                        ru
                    </div>
                </a>
            </div>
        </div>
    </body>
</html>
