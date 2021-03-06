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

package com.skalicky.cryptobot.exchange.slack.connector.impl.logic;

import com.skalicky.cryptobot.exchange.shared.connector.impl.logic.RestConnectorSupport;
import com.skalicky.cryptobot.exchange.slack.connector.api.logic.SlackConnector;
import com.skalicky.cryptobot.exchange.slack.connector.impl.dto.SlackSendMessageRequest;

import javax.annotation.Nonnull;

public class SlackConnectorImpl implements SlackConnector {

    @Nonnull
    private final RestConnectorSupport restConnectorSupport;

    public SlackConnectorImpl(@Nonnull final RestConnectorSupport restConnectorSupport) {
        this.restConnectorSupport = restConnectorSupport;
    }

    @Override
    public void sendMessage(@Nonnull final String text,
                            @Nonnull final String webhookUrl) {
        restConnectorSupport.postJson(new SlackSendMessageRequest(text), webhookUrl);
    }
}
