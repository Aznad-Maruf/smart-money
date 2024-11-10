package hood.robin.smartmoney.service;

import hood.robin.smartmoney.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CategoryService {

    @PersistenceContext
    private EntityManager em;

    public Category getCategory(UUID uuid) {
        return em.createNamedQuery("Category.findByUuid", Category.class)
                .setParameter("uuid", uuid)
                .getSingleResult();
    }

    @Transactional
    public Category save(Category category) {
        em.persist(category);

        return category;
    }

    @Transactional
    public Category update(Category category) {
        em.merge(category);

        return category;
    }

    public List<Category> findAll() {
        return em.createNamedQuery("Category.findAll", Category.class)
                .getResultList();
    }
}
