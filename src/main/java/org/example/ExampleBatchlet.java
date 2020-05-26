package org.example;

import java.util.Properties;
import javax.batch.api.AbstractBatchlet;
import javax.batch.api.BatchProperty;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Dependent
public class ExampleBatchlet extends AbstractBatchlet {

  @Inject
  private JobContext jobContext;

  @Inject
  @BatchProperty
  private String message;

  @Inject
  @BatchProperty
  private String id;

  @Override
  public String process() throws Exception {
    System.out.println("###### start ######");

    Properties properties = jobContext.getProperties();
    System.out.println("************ " + properties.getProperty("jobProperty"));
    System.out.println("************ " + message);

    System.out.println("###### end ######");
    return "success";
  }
}
