package com.demo.test.mock;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TestRealCase {

    private TopicManager topicManager = new TopicManager();


    @Test
    public void testGetAllTopicReturnThreeTopic() {
        // 3A pattern

        // Arrange
        String result = "Hot topic";
        TopicDAO mockDAO = Mockito.mock(TopicDAO.class);
        topicManager.setTopicDAO(mockDAO);
        Mockito.when(mockDAO.getTrendTopic(Mockito.any(Date.class))).thenReturn("Hot topic");

        // Act
        String trendTopic = topicManager.getTrendTopic(new Date());

        // Assert
        // Use Mockito.verify() the interaction between SUT & DOC.
        // Use Mockito.times() to check how many times DOC was called by SUT.
        // Use Mockito.any() to match any case of input type.
        Mockito.verify(mockDAO, Mockito.times(1)).getTrendTopic(Mockito.any(Date.class));
        Assertions.assertEquals(result, trendTopic);
    }

    class TopicManager {
        private TopicDAO topicDAO;
        public void setTopicDAO(TopicDAO topicDAO) {
            this.topicDAO = topicDAO;
        }
        public String getTrendTopic(Date date) {
            return topicDAO.getTrendTopic(date);
        }
    }

    class TopicDAO {
        public String getTrendTopic(Date date) {
            //Get data from db
            return "Topic Two";
        }
    }
}
