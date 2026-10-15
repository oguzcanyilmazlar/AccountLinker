package me.acablade.sboxgaming.platform;

import me.acablade.sboxgaming.provider.AccountLinking;

import java.util.*;

public final class PlatformBuilder<T extends AccountLinkingActor> {

    private final ActorCodec<T> codec;
    private Map<String, AccountLinking<T>> providers;

    public PlatformBuilder(ActorCodec<T> codec){
        this.providers = new HashMap<>();
        this.codec = Objects.requireNonNull(codec, "codec cannot be null!");
    }

    public PlatformBuilder<T> addProvider(AccountLinking<T> provider){
        this.providers.put(provider.id(), provider);
        return this;
    }

    @SafeVarargs
    public final PlatformBuilder<T> providers(AccountLinking<T>... providers){
        Map<String, AccountLinking<T>> temp = new HashMap<>();
        for(AccountLinking<T> provider: providers){
            temp.put(provider.id(), provider);
        }
        this.providers = temp;
        return this;
    }

    public AccountLinkingPlatform<T> build(){
        return new AccountLinkingPlatform<>(codec, providers);
    }


}
