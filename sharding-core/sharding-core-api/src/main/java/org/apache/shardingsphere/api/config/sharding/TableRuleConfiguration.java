/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.api.config.sharding;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.api.config.sharding.strategy.ShardingStrategyConfiguration;

/**
 * Table rule configuration.
 */
@Getter
@Setter
public final class TableRuleConfiguration {
    // logicTable逻辑表（比如account_1、account2以此类推，这种类型的表统称为account）
    private final String logicTable;
    // 实际的表 比如:test0.account_0,test0.account_2,test1.account_1,test1.account_3    也可以是表达式
    private final String actualDataNodes;
    // 数据库分库策略配置
    private ShardingStrategyConfiguration databaseShardingStrategyConfig;
    // 数据库分表策略配置
    private ShardingStrategyConfiguration tableShardingStrategyConfig;
    // 主键生成规则配置
    private KeyGeneratorConfiguration keyGeneratorConfig;
    
    public TableRuleConfiguration(final String logicTable) {
        this(logicTable, null);
    }
    
    public TableRuleConfiguration(final String logicTable, final String actualDataNodes) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(logicTable), "LogicTable is required.");
        this.logicTable = logicTable;
        this.actualDataNodes = actualDataNodes;
    }
}
