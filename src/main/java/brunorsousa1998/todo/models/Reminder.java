package brunorsousa1998.todo.models;

import brunorsousa1998.todo.validators.ReminderValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
	name = "reminders"
)
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
@EqualsAndHashCode(of = {"id"})
public class Reminder {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Null(groups = {
		ReminderValidator.create.class
	})
	private UUID id;

	@Column(name = "title", nullable = false)
	@NotNull(groups = {
		ReminderValidator.create.class
	})
	@NotEmpty(groups = {
		ReminderValidator.create.class
	})
	private String title;

	@Column(name = "description")
	@Size(min = 1, groups = {
		ReminderValidator.create.class
	})
	private String description;

	@Column(name = "ends_at", nullable = false)
	@NotNull(groups = {
		ReminderValidator.create.class
	})
	private LocalDateTime endsAt;

	@Column(name = "done", nullable = false)
	@Null(groups = {
		ReminderValidator.create.class
	})
	private Boolean done;
}
