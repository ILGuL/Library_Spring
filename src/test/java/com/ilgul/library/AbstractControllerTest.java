package com.ilgul.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilgul.library.dto.BookDto;
import com.ilgul.library.dto.ClientDto;
import com.ilgul.library.repository.BookRepository;
import com.ilgul.library.repository.ClientRepository;
import com.ilgul.library.service.TimeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractControllerTest {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected ClientRepository clientRepository;
    @Autowired
    protected BookRepository bookRepository;

    @MockBean
    protected TimeService timeService;

    @SneakyThrows
    protected ResultActions createClient(ClientDto dto){
        return mockMvc.perform(post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)));
    }

    protected ClientDto mockClient() {
        ClientDto dto = new ClientDto();
        dto.setFirstName("Bred");
        dto.setLastName("Pitt");
        dto.setEmail("bredpitt@gmail.com");
        dto.setPhone("+34501234567");

        return dto;
    }

    @SneakyThrows
    protected ResultActions createBook(BookDto dto){
        return mockMvc.perform(post("/book").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)));
    }

    protected BookDto mockBook() {
        BookDto testBook = new BookDto();
        testBook.setName("Test name");
        testBook.setDescription("Test description");
        testBook.setAuthor("Test author");
        testBook.setPublisher("Test publisher");
        testBook.setYear(2020);
        testBook.setIsbn("978-617-7866-64-9");

        return testBook;
    }
}
