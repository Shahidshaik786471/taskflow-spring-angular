package com.gnanesh.taskflow.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Task {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String status; // TODO / DOING / DONE
  private String assignee;
  private LocalDateTime createdAt = LocalDateTime.now();
  public Task() {}
  public Task(String title, String status, String assignee){this.title=title;this.status=status;this.assignee=assignee;}
  public Long getId(){return id;}
  public String getTitle(){return title;} public void setTitle(String v){this.title=v;}
  public String getStatus(){return status;} public void setStatus(String v){this.status=v;}
  public String getAssignee(){return assignee;} public void setAssignee(String v){this.assignee=v;}
  public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){this.createdAt=v;}
}
