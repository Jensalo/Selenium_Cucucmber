

Feature: academia es presentada de forma correcta para potenciales clientes




  @Academia
  Scenario: Usuario navega a la opción academia
    When Voy a academia usando la barra de navegación
    When El usuario selecciona Empezar hoy
    And El usuario valida las opciones de planes de pago

