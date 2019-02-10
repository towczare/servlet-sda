<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
    <link rel="stylesheet" href="css/pizza.css" />
    <title>Order pizza</title>
</head>
<body>
  <h1>Pizza as a service</h1>

  <form method="post" action="/pizza-servlet/audio" class="w3-container">
      <div class="w3-container w3-red">
          <h1>Składniki na pizze</h1>
          <p>
          <c:forEach items="${pizzaComponents}" var="component">
              <input type="checkbox" name="components" id="${component}" value="${component.getPolishSpelling()}" class="w3-check" />
              <label for="${component}">${component.getPolishSpelling()}</label>
          </c:forEach>
          </p>
      </div>
      <div class="w3-container w3-green">
          <h1>Adres zamówienia</h1>
          <p>
              <label for="address" >Adres:</label>
              <input type="text" name="address" id="address" class="w3-input w3-animate-input"/>
          </p>
      </div>
      <div class="w3-container w3-teal">
          <h1>Numer telefonu</h1>
          <p>
              <label for="phone" >Numer telefonu: (w formacie 111-222-333)</label>
              <input type="text" name="phone" id="phone" class="w3-input w3-animate-input" />
          </p>
      </div>
      <div class="w3-container w3-khaki">
          <h1>Kto ma zamówić?</h1>
              <div class="w3-quarter w3-center">
                  <label>
                      <h2>Maja</h2>
                      <input type="radio" name="person" value="Maja" checked>
                      <img src="img/maja.png" />
                  </label>
              </div>
              <div class="w3-quarter w3-center">
                  <label>
                      <h2>Ewa</h2>
                      <input type="radio" name="person" value="Ewa">
                      <img src="img/ewa.png" />
                  </label>
              </div>
              <div class="w3-quarter w3-center">
                  <label>
                      <h2>Jacek</h2>
                      <input type="radio" name="person" value="Jacek">
                      <img src="img/jacek.png" />
                  </label>
              </div>
              <div class="w3-quarter w3-center">
                  <label>
                      <h2>Jan</h2>
                      <input type="radio" name="person" value="Jan">
                      <img src="img/jan.png" />
                  </label>
              </div>
          </div>
      <input type="submit" value="Generate new call" class="w3-btn w3-blue-grey"/>
  </form>
  <audio src="/pizza-servlet/audio" controls>Dzwonimy!</audio>

</body>
</html>
