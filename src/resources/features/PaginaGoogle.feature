Feature: Probar la búsqueda en Google

  Background:
    Given el usuario abre el navegador

  @Google
  Rule: Búsquedas en el motor de Google

    Example: Búsqueda válida
      Given El usuario esta en la página de búsqueda de Google.
      When Introduce un criterio de búsqueda.
  #Then Los resultados coinciden con los criterios.

  # Example: Campo de búsqueda vacío
  #  Given El usuario esta en la página de búsqueda de Google.
  #  When No introduce ningún criterio de búsqueda.
  #  Then Se debe mostrar un mensaje de error o no realizar búsqueda.
