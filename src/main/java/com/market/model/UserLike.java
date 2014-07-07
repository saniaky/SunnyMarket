package com.market.model;

import javax.persistence.*;

/**
 * Created by saniaky on 7/5/14.
 */
@Entity
@Table(name = "likes")
public class UserLike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "owner_id")
    private Long owner_id;

    @Column(name = "recipient_id")
    private Long recipient_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "decision")
    private LikeEnum decision;

    public UserLike() {
    }

    public UserLike(Long owner_id, Long recipient_id, LikeEnum decision) {
        this.owner_id = owner_id;
        this.recipient_id = recipient_id;
        this.decision = decision;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public Long getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(Long recipient_id) {
        this.recipient_id = recipient_id;
    }

    public LikeEnum getDecision() {
        return decision;
    }

    public void setDecision(LikeEnum decision) {
        this.decision = decision;
    }
}
