package hood.robin.smartmoney.service;

import hood.robin.smartmoney.entity.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessageService implements BaseService<Message> {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Message save(Message entity) {
        em.persist(entity);

        return entity;
    }

    @Override
    @Transactional
    public Message update(Message entity) {
        return em.merge(entity);
    }

    @Transactional
    public Message delete(Message entity) {
        em.remove(entity);

        return entity;
    }

    @Override
    public List<Message> findAll() {
        return em.createNamedQuery("Message.findAll", Message.class)
                .getResultList();
    }

    @Override
    public Message find(UUID uuid) {
        return em.createNamedQuery("Message.findByUuid", Message.class)
                .setParameter("uuid", uuid)
                .getSingleResult();
    }
}
