package me.acablade.sboxgaming.provider;

import me.acablade.sboxgaming.AccountLinkingConfig;
import me.acablade.sboxgaming.link.Link;
import me.acablade.sboxgaming.link.LinkStore;
import me.acablade.sboxgaming.platform.AccountLinkingActor;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// will be implemented through numbis probably.
public final class AccountLinkingGoogle<T extends AccountLinkingActor> implements AccountLinking<T> {

    private final AccountLinkingConfig config;
    private final LinkStore<T> store;
    private final Map<String, T> pending;

    public AccountLinkingGoogle(AccountLinkingConfig config, LinkStore<T> store) {
        this.config = config;
        this.store = store;
        this.pending = new HashMap<>(); // HashMap because using concurrenthashmap here doesnt really make a difference(i think?)
    }

    @Override
    public String id() {
        return "google";
    }

    @Override
    public URI startLink(T actor) {
        throw new UnsupportedOperationException("not implemented.");
    }

    @Override
    public Link<T> completeLink(String state, String code) {
        throw new UnsupportedOperationException("not implemented.");
    }

    @Override
    public Optional<Link<T>> find(T actor) {
        throw new UnsupportedOperationException("not implemented.");
    }

    @Override
    public void unlinkActor(T actor) {
        throw new UnsupportedOperationException("not implemented.");
    }

    @Override
    public void unlinkEmail(String email) {
        throw new UnsupportedOperationException("not implemented.");
    }
}
