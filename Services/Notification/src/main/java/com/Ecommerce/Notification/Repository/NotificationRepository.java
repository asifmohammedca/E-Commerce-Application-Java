package com.Ecommerce.Notification.Repository;

import com.Ecommerce.Notification.Model.Entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NotificationRepository extends MongoRepository<Notification,String> {
}
