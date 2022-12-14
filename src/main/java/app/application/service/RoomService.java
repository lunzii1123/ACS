package app.application.service;

import app.application.model.Employee;
import app.application.model.Room;
import app.application.model.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomService {

    private final app.application.repository.RoomRepository roomRepository;

    public RoomDto getById(UUID id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()) {
            return Room.mapToDto(room.get());
        } else {
            throw new RuntimeException("User with id: [" + id + "] not found.");
        }
    }

    public List<RoomDto> getAll() {
        return roomRepository.findAll().stream().map(Room::mapToDto).collect(Collectors.toList());
    }

    public void deleteById(UUID id) {
        roomRepository.findById(id).ifPresent(room -> roomRepository.deleteById(id));
    }

    public RoomDto save(RoomDto roomDto) {
        return Room.mapToDto(roomRepository.save(Room.mapToEntity(roomDto)));
    }


}
