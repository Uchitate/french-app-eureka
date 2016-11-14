package co.jp.tagbangers.core.repository;

import co.jp.tagbangers.core.entity.French;
import co.jp.tagbangers.core.entity.French_;
import co.jp.tagbangers.core.model.FrenchSearchRequest;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FrenchRepositoryImpl implements FrenchRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<French> search(FrenchSearchRequest request) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<French> query = builder.createQuery(French.class);
		Root<French> root = query.from(French.class);

		List<Predicate> where = new ArrayList<>();
		if (StringUtils.hasText(request.getName())) {
			where.add(builder.equal(root.get(French_.name), request.getName()));
		}

		query.where(where.toArray(new Predicate[where.size()]));

		return entityManager.createQuery(query).getResultList();
	}
}
