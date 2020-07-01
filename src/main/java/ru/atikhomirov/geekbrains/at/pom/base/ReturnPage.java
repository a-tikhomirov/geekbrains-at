package ru.atikhomirov.geekbrains.at.pom.base;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.atikhomirov.geekbrains.at.pom.page.*;

@Component
public abstract class ReturnPage extends Actions {
    @Autowired
    @Getter
    private CoursesPage coursesPage;
    @Autowired
    @Getter
    private CareerPage careerPage;
    @Autowired
    @Getter
    private EventsPage eventsPage;
    @Autowired
    @Getter
    private TopicsPage topicsPage;
    @Autowired
    @Getter
    private PostsPage postsPage;
    @Autowired
    @Getter
    private TestsPage testsPage;
}
