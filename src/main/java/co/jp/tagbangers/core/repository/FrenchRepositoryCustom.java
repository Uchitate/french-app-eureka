package co.jp.tagbangers.core.repository;

import co.jp.tagbangers.core.entity.French;
import co.jp.tagbangers.core.model.FrenchSearchRequest;

import java.util.List;

public interface FrenchRepositoryCustom {

	List<French> search(FrenchSearchRequest request);
}
