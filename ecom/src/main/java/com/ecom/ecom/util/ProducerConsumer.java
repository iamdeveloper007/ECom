package com.ecom.ecom.util;

import com.ecom.ecom.entity.UserDetail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;

public class ProducerConsumer {

  // Create a list shared by producer and consumer
  // Size of list is 2.
  public static LinkedList<UserDetail> orderDetail = new LinkedList<>();
  int capacity = 2;

  // Function called by producer thread
  public void produce(UserDetail userDetail) throws InterruptedException {

      synchronized (this) {
        while (orderDetail.size() == capacity)
          wait();
        // now it can start consuming
        notify();

        // makes the working of program easier
        // to  understand
        Thread.sleep(1000);
      }
    }

  // Function called by consumer thread
  public void consume() throws InterruptedException {
    while (true) {
      synchronized (this) {
        // consumer thread waits while list
        // is empty
        while (orderDetail.size() == 0)
          wait();

        UserDetail userDetail = orderDetail.removeFirst();
        try {

          String from = "ecom@gmail.com";
          String host = "ecom.host";
          Properties properties = System.getProperties();
          properties.setProperty("mail.smtp.host", host);
          Session session = Session.getDefaultInstance(properties);
          MimeMessage message = new MimeMessage(session);
          message.setFrom(new InternetAddress(from));
          message.addRecipient(Message.RecipientType.TO, new InternetAddress(userDetail.getPrimaryEmailId()));
          message.setSubject("You orderId has been processed");
          message.setText(userDetail.getProductDetailList().toString());
          Transport.send(message);
        } catch (MessagingException mex) {
          mex.printStackTrace();
        }
        notify();
        // and sleep
        Thread.sleep(1000);
      }
    }
  }
}

