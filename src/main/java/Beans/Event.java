package Beans;

import java.util.Date;
import java.util.Random;
import org.springframework.util.StringUtils;

public class Event {

  private int id;
  private String msg;
  private Date date;

  public Event(String msg, Date date) {
    Random random = new Random();
    this.id = random.nextInt();

    this.date = date;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "Event{" +
        "id=" + id +
        ", msg='" + msg + '\'' +
        ", date=" + date +
        '}';
  }

}
