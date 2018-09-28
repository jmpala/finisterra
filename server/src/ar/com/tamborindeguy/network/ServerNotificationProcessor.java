package ar.com.tamborindeguy.network;

import ar.com.tamborindeguy.manager.WorldManager;
import ar.com.tamborindeguy.network.interfaces.INotification;
import ar.com.tamborindeguy.network.interfaces.INotificationProcessor;
import ar.com.tamborindeguy.network.notifications.EntityUpdate;
import ar.com.tamborindeguy.network.notifications.RemoveEntity;

public class ServerNotificationProcessor implements INotificationProcessor {
    @Override
    public void defaultProcess(INotification notification) {

    }

    @Override
    public void processNotification(EntityUpdate entityUpdate) {
        int entityId = entityUpdate.entityId;
        WorldManager.notifyUpdateToNearEntities(entityId, entityUpdate.components);
    }

    @Override
    public void processNotification(RemoveEntity removeEntity) {
        defaultProcess(removeEntity);
    }
}