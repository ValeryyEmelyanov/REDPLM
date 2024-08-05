package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.EPAKType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PAK")
public class PAK {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    private LocalDateTime assemblyStartDate = LocalDateTime.now();

    private LocalDateTime assemblyEndDate = LocalDateTime.now().plusDays(1);

    private BigDecimal cost = BigDecimal.ZERO;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "swAssembly_id")
    private SWAssembly swAssembly;

    @Enumerated(EnumType.STRING)
    private EPAKType pakType;


}
