package brunorsousa1998.todo.controllers;

import brunorsousa1998.todo.models.Reminder;
import brunorsousa1998.todo.services.ReminderService;
import brunorsousa1998.todo.validators.ReminderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reminders")
@RequiredArgsConstructor
public class ReminderController {

	private final ReminderService service;

	@GetMapping("/{id}")
	public Reminder findOne(@PathVariable UUID id) {
		return this.service.findOne(id);
	}

	@GetMapping
	public List<Reminder> findAll() {
		return this.service.findAll();
	}

	@PostMapping
	public Reminder create(@Validated(ReminderValidator.create.class) @RequestBody Reminder data) {
		return this.service.create(data);
	}
}
