package br.com.yuripedrosa.gestao_vagas.modules.candidate.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Yuri Pedrosa", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "O campo [name] é obrigatório!")
    private String name;

    @Schema(example = "Yuri", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "O campo [username] é obrigatório!")
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço!")
    private String username;

    @Schema(example = "yuri@gmail.com", requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "O campo [email] é obrigatório!")
    @Email(message = "O campo [email] deve conter um email válido!")
    private String email;

    @Schema(example = "senha@123", minLength = 6, maxLength = 100, requiredMode = RequiredMode.REQUIRED)
    @NotBlank(message = "O campo [password] é obrigatório!")
    @Length(min = 6, max = 100, message = "O campo [senha] deve conter entre 6 e 100 caracteres!")
    private String password;

    @Schema(example = "Desenvolvedor Java Júnior")
    private String description;

    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
}
