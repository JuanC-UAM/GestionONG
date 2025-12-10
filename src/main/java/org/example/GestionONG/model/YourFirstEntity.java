package org.example.GestionONG.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.model.Identifiable;

@Entity
@Getter
@Setter
public class YourFirstEntity extends Identifiable {

    @Column(length = 50)
    @Required
    @MaxSize(50)
    private String description;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalcul
