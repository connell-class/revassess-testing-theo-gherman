select * from app_user full outer join study_set 
	ON app_user.user_id = study_set.owner_id 
	where app_user.user_id = 5;