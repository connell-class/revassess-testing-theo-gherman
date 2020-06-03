select app_user.username, study_set.name as set_name, category.name as category_name, flashcard.question, flashcard.answer
	from 
		app_user
		inner join study_set 
			on app_user.user_id = study_set.owner_id
		inner join study_set_card 
			on study_set.study_set_id = study_set_card.study_set_id 
		inner join flashcard 
			on study_set_card.flashcard_id = flashcard.flashcard_id 
		inner join category 
			on flashcard.category_id = category.category_id 
	where 
		study_set.study_set_id =4;