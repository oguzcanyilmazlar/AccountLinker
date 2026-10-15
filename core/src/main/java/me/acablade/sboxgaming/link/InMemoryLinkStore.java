package me.acablade.sboxgaming.link;

import me.acablade.sboxgaming.platform.AccountLinkingActor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class InMemoryLinkStore<T extends AccountLinkingActor> implements LinkStore<T> {

    private final Map<T, Link<T>> byActor = new HashMap<>();
    private final Map<String, Link<T>> bySubject = new HashMap<>();
    private final Map<String, Link<T>> byEmail = new HashMap<>();

    @Override
    public synchronized void save(Link<T> link) {
        remove(byActor.get(link.actor()));
        remove(bySubject.get(link.subject()));
        if(link.email() != null) remove(byEmail.get(link.email()));

        byActor.put(link.actor(), link);
        bySubject.put(link.subject(), link);
        if(link.email() != null) byEmail.put(link.email(), link);
    }

    @Override
    public synchronized Optional<Link<T>> findByActor(T actor) {
        return Optional.ofNullable(byActor.get(actor));
    }

    @Override
    public synchronized Optional<Link<T>> findBySubject(String subject) {
        return Optional.ofNullable(bySubject.get(subject));
    }

    @Override
    public synchronized Optional<Link<T>> findByEmail(String email) {
        return Optional.ofNullable(byEmail.get(email));
    }

    @Override
    public synchronized void delete(Link<T> link) {
        remove(link);
    }

    private void remove(Link<T> link){
        if(link == null) return;
        byActor.remove(link.actor(), link);
        bySubject.remove(link.subject(), link);
        if(link.email() != null) byEmail.remove(link.email(), link);
    }
}
