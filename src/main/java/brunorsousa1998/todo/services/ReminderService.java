package brunorsousa1998.todo.services;

import brunorsousa1998.todo.models.Reminder;
import brunorsousa1998.todo.repositories.ReminderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReminderService {

	private final ReminderRepository repository;

	public Reminder findOne(UUID id) {
		return this.repository
			.findById(id)
			.orElseThrow(
				() -> new RuntimeException("Reminder not found!")
			);
	}

	public List<Reminder> findAll() {
		return this.repository.findAll();
	}

	public Reminder create(
		Reminder data
	) {

		LocalDateTime endsAt = data.getEndsAt();

		if(endsAt.isBefore(LocalDateTime.now(ZoneOffset.UTC))) {
			throw new RuntimeException("Reminder should end at a future time!");
		}

		return this.repository.save(
			Reminder
				.builder()
				.title(data.getTitle())
				.description(data.getDescription())
				.endsAt(data.getEndsAt())
				.done(false)
				.build()
		);
	}
}
