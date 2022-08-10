package app.instabillpos.repository.local.products

import androidx.lifecycle.LiveData
import androidx.room.*
import app.instabillpos.mProguard.Model.CreateOrder
import app.instabillpos.mProguard.Model.CreateOrderr

import app.instabillpos.repository.entities.products.Data

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAllProducts() : LiveData<List<Data>>

    @Query("SELECT * FROM products WHERE id = :id")
    fun getCharacter(id: Int): LiveData<Data>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<Data>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(products: Data)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvoice(products: CreateOrderr)

    @Query("SELECT * FROM offlineInvoice")
    fun getOfflineInvoice() : LiveData<List<CreateOrderr>>

    @Delete
    fun deleteOfflineInvoice(model: CreateOrderr)
}