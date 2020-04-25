package net.benfro.curiae.plannerbackend.domain;

import lombok.Data;

import java.util.List;

@Data
public class Item {

   private long id;
   private String title;
   private String subTitle;
   private String opus;
   List<Author> items;
}
