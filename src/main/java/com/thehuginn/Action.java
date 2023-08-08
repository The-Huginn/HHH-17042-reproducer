package com.thehuginn;

import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Entity
@Table(name = "actions")
public class Action {
    
    @Id
    public Long id;

    @Column(name = "action_details")
    public String actionDetails = "details";

    @ManyToOne(fetch = FetchType.LAZY)
    public Location location;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "action")
    public Set<Lead> lead;
    
    @Entity
    @Table(name = "location")
    public static class Location {

        @Id
        Long id;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
        Set<Action> action;
    }

    @Entity
    @Table(name = "leads")
    public static class Lead {

        @Id
        Long id;

        @ManyToOne
        Action action;
    }

    @Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
    @StaticMetamodel(Action.class)
    public static abstract class Action_ {
        public static volatile SingularAttribute<Action, Long> id;
        public static volatile SingularAttribute<Action, String> actionDetails;
        public static volatile SingularAttribute<Action, Location> location;
        public static volatile SingularAttribute<Action, Lead> lead;

        public static final String LOCATION = "location";
        public static final String LEAD = "lead";
    }

    public static class ActionPOJO {
        public Long id;
        public String actionDetails;
        public Location location;
        public Lead lead;

        public ActionPOJO() {}

        public ActionPOJO(Long id, String actionDetails, Location location, Lead lead) {
            this.id = id;
            this.actionDetails = actionDetails;
            this.location = location;
            this.lead = lead;
        }
    }
}
