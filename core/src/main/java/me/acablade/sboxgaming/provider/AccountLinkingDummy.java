package me.acablade.sboxgaming.provider;

import me.acablade.sboxgaming.link.Link;
import me.acablade.sboxgaming.link.LinkStore;
import me.acablade.sboxgaming.platform.AccountLinkingActor;

import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// dummy provider for testing.
public final class AccountLinkingDummy<T extends AccountLinkingActor> implements AccountLinking<T> {

    private final LinkStore<T> store;
    private final Map<String, T> pending = new ConcurrentHashMap<>(); // state -> actor

    public AccountLinkingDummy(LinkStore<T> store){
        this.store = store;
    }

    @Override
    public String id() {
        return "dummy";
    }

    @Override
    public URI startLink(T actor) {
        String state = UUID.randomUUID().toString();
        pending.put(state, actor);
        return URI.create("https://dummy.invalid/authorize?state=" + state);
    }

    @Override
    public Link<T> completeLink(String state, String code) {
        T actor = pending.remove(state);
        if(actor == null) throw new IllegalArgumentException("unknown or expired state: " + state);

        unlinkActor(actor);
        Link<T> link = new Link<>(actor, "dummy-" + code, code);
        store.save(link);
        return link;
    }

    @Override
    public Optional<Link<T>> find(T actor) {
        return store.findByActor(actor);
    }

    @Override
    public void unlinkActor(T actor) {
        store.findByActor(actor).ifPresent(store::delete);
    }

    @Override
    public void unlinkEmail(String email) {
        store.findByEmail(email).ifPresent(store::delete);
    }
}
