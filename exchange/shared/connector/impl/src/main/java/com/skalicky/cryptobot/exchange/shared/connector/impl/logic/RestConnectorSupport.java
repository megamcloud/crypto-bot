/*
 * A program to automatically trade cryptocurrencies.
 * Copyright (C) 2020 Tomas Skalicky
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.skalicky.cryptobot.exchange.shared.connector.impl.logic;

import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class RestConnectorSupport {

    @Nonnull
    private static final Logger logger = LoggerFactory.getLogger(RestConnectorSupport.class);
    @Nonnull
    private static final Client client = ClientBuilder.newClient(new ClientConfig());

    public <T> void postJson(@Nonnull final T requestPayload,
                             @Nonnull final String targetUrl) {
        final var webTarget = client.target(targetUrl);

        final var invocationBuilder = webTarget.request();
        final var requestEntity = Entity.entity(requestPayload, MediaType.APPLICATION_JSON);

        logger.debug("URI {} - Request: {}", targetUrl, requestEntity);

        final var response = invocationBuilder.post(requestEntity);

        final var responseString = response.readEntity(String.class);
        final var maxLength = 512;
        final var showDots = responseString.length() > maxLength;
        logger.debug("URI {} - Raw Response: {}{}", targetUrl,
                responseString.substring(0, Math.min(maxLength, responseString.length())), showDots ? "..." : "");

        if (response.getStatus() >= 300) {
            throw new IllegalStateException("Unexpected response status. Response: " + response);
        }
    }

}
