package com.bmuschko.gradle.docker.tasks.network

import com.bmuschko.gradle.docker.tasks.AbstractDockerRemoteApiTask
import groovy.transform.CompileStatic
import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Input

import java.util.concurrent.Callable

@CompileStatic
abstract class DockerExistingNetwork extends AbstractDockerRemoteApiTask {
    /**
     * The name of the network to perform the operation on.
     */
    @Input
    final Property<String> networkId = project.objects.property(String)

    void targetNetworkId(String networkId) {
        this.networkId.set(networkId)
    }

    void targetNetworkId(Callable<String> networkId) {
        targetNetworkId(project.provider(networkId))
    }

    void targetNetworkId(Provider<String> networkId) {
        this.networkId.set(networkId)
    }
}
