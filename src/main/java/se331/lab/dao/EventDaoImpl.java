package se331.lab.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Event;
import se331.lab.repository.EventRepository;

@Repository
@Primary
@Profile("db")
public class EventDaoImpl extends EventDaoDbImpl {
    public EventDaoImpl(EventRepository eventRepository) {
        super(eventRepository);
    }

    @Override
    public Page<Event> getEvents(String title, Pageable page) {
        return eventRepository.findByTitleIgnoreCaseContainingOrDescriptionIgnoreCaseContainingOrOrganizer_NameIgnoreCaseContaining(
                title, title, title, page);
    }
}
