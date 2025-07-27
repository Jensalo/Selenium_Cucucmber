#Feature: Visitar sitio Free Range Testers y navegar por barra de opciones

#Scenario: Usuario navega al sitio principal
#Given el usuario abre el navegador
#When Voy a la sección usando la barra de navegación

#Scenario Outline => significa que tienes varios escenarios

Feature: Visitar sitio Free Range Testers y navegar por barra de opciones


  Background:
    Given el usuario abre el navegador en la sección

  @FreeRange
  Scenario: Usuario navega al sitio principal
    When Voy a la "<sección>" usando la barra de navegación


    Examples:
      #Los marcados no los encuentra
      #| Academia  |
      | Cursos |
# | Mentorías |
# | udemy     |
# | Blog      |
# | Recursos  |




