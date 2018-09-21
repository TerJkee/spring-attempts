import Beans.Client;
import Beans.Event;
import logger.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  private Client client;
  private EventLogger eventLogger;

  App(Client client, EventLogger eventLogger) {
    this.client = client;
    this.eventLogger = eventLogger;
  }

  private void logEvent(Event event) {

    eventLogger.logEvent(event);
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    App app = (App) ctx.getBean("app");
    App app1 = ctx.getBean(App.class);

  }


}
