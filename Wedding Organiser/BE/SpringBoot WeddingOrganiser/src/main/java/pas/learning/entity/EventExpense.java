package pas.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@Table(name = "Event_expense")
public class EventExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_expense_id")
    private int eventExpanseId;

    @Column(name = "description")
    private String description;

    @Column(name = "expense_type")
    private String expenseType;

    @Column(name = "cost")
    private double cost;

    @Column(name = "paid")
    private double paid;

    @Column(name = "currency")
    private String currency;

    @Column(name = "additional_comment")
    private String additionalComment;

    // budget ID
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "budget_id", referencedColumnName = "budget_id")
    private Budget budget;

    // expanse id
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "expense_id", referencedColumnName = "expense_id")
    private Expense expense;

    // service id
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Service service;

}
