package com.example.expensetracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.R
import com.example.expensetracker.ui.theme.incomeGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .background(color = MaterialTheme.colorScheme.background),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        stringResource(R.string.app_title),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },


                scrollBehavior = scrollBehavior,
            )
        },

        ) { innerPadding ->

        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            MoneyCard(Modifier.padding(12.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier = Modifier.weight(1f)
                        .padding(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.size(40.dp).background(color = incomeGreen.copy(alpha = 0.12f), shape = CircleShape),
                            contentAlignment = Alignment.Center,
                            ){
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                                contentDescription = "Income this month",
                                tint = incomeGreen
                            )
                        }
                        
                        Column(
                            modifier = Modifier.padding(start = 10.dp)
                        ) {
                            Text(
                                "Income",
                                style = MaterialTheme.typography.labelMedium
                            )
                            Text(
                                "₹15000",
                                style = MaterialTheme.typography.titleMedium,
                                color = incomeGreen,

                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier.weight(1f)
                        .padding(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(modifier = Modifier.size(40.dp).background(color =MaterialTheme.colorScheme.error.copy(alpha = 0.12f) , shape = CircleShape),
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.TrendingDown,
                                contentDescription = "Expense this month",
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                        Column(
                            modifier = Modifier.padding(start = 10.dp)
                        ) {
                            Text(
                                "Expense",
                                style = MaterialTheme.typography.labelMedium
                            )
                            Text(
                                "₹2550",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Recent Transactions",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    "View All",
                    style = MaterialTheme.typography.titleMedium
                )

            }

            Spacer(modifier = Modifier.height(5.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),

                ) {
                TransactionCard(
                    title = "Zomato",
                    category = "Food",
                    amount = "₹320",
                    date = "Today",
                    icon = Icons.Default.Restaurant
                )

                TransactionCard(
                    title = "Uber",
                    category = "Transport",
                    amount = "₹180",
                    date = "Today",
                    icon = Icons.Default.DirectionsCar
                )

                TransactionCard(
                    title = "Grocery Store",
                    category = "Groceries",
                    amount = "₹1,240",
                    date = "Yesterday",
                    icon = Icons.Default.ShoppingCart
                )

                TransactionCard(
                    title = "Netflix",
                    category = "Entertainment",
                    amount = "₹499",
                    date = "22 Sep",
                    icon = Icons.Default.Movie
                )

                TransactionCard(
                    title = "Electricity Bill",
                    category = "Bills",
                    amount = "₹850",
                    date = "20 Sep",
                    icon = Icons.Default.Bolt
                )

                TransactionCard(
                    title = "College Stipend",
                    category = "Income",
                    amount = "₹5,000",
                    date = "18 Sep",
                    icon = Icons.Default.AccountBalanceWallet,
                    isIncome = true
                )

            }
        }

    }
}


@Composable
fun MoneyCard(
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 12.dp
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Total Balance",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    text = "₹ 12,450",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Icon(
                imageVector = Icons.Default.Visibility,
                contentDescription = "Hide balance",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun TransactionCard(
    modifier: Modifier = Modifier,
    title: String,
    category: String,
    amount: String,
    date: String,
    icon: ImageVector,
    isIncome: Boolean = false
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.width(12.dp))


            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = category,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }


            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = if (isIncome) "+ $amount" else "- $amount",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = if (isIncome)
                        incomeGreen
                    else
                        MaterialTheme.colorScheme.error
                )

                Text(
                    text = date,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}