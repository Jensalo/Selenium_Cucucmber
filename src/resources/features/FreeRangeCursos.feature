Feature: los cursos son presentados de forma correcta para potenciales clientes


  Background:
    Given El usuario abre el navegador en la sección Cursos

  @onlyCursos
  Scenario: Usuario navega a la opción cursos
    When Voy a cursos usando la barra de navegación
    And Selecciono Introducción al Testing de Software
