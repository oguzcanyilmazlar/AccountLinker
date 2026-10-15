package me.acablade.sboxgaming.link;

import me.acablade.sboxgaming.platform.AccountLinkingActor;

import java.util.Optional;

public interface LinkStore<T extends AccountLinkingActor> {
    void save(Link<T> link);
    Optional<Link<T>> findByActor(T actor);
    Optional<Link<T>> findBySubject(String subject);
    Optional<Link<T>> findByEmail(String email);
    void delete(Link<T> link);
}