package co.jp.tagbangers.core.repository;

import co.jp.tagbangers.core.entity.User;
import co.jp.tagbangers.core.model.UserSearchRequest;

import java.util.List;

public interface UserRepositoryCustom {

	List<User> search(UserSearchRequest request);
}
