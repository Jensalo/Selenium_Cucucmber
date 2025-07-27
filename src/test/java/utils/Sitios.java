package utils;

public enum Sitios {
  FREE_RANGE("https://www.freerangetesters.com/"),
  GOOGLE("https://www.google.com/?hl=es"),
  PRACTICE_FORM("https://demoqa.com/automation-practice-form");

  private final String url;

  Sitios(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }
}
