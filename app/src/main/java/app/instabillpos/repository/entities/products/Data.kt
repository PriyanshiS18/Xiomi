package app.instabillpos.repository.entities.products


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products")
data class Data(

    @SerializedName("discount_status")
    var discount_status: String?,
    @SerializedName("discount_amount")
    var discount_amount: String?,
    @SerializedName("barcode_id")
    var barcodeId: String?,
    @SerializedName("cess_charge")
    var cessCharge: String?,
    @SerializedName("company_id")
    var companyId: String?,
    @SerializedName("created")
    var created: String?,
    @SerializedName("current_quantity")
    var currentQuantity: String?,
    @SerializedName("date")
    var date: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("discount")
    var discount: String?,
    @SerializedName("discount_value")
    var discountValue: String?,
    @SerializedName("hsn")
    var hsn: String?,


    @PrimaryKey
    @SerializedName("id")
    var id: String,

    @SerializedName("image")
    var image: String?,
    @SerializedName("import_id")
    var importId: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("opening_stock_quantity")
    var openingStockQuantity: String?,
    @SerializedName("opening_stock_value")
    var openingStockValue: String?,
    @SerializedName("product_categorey")
    var productCategorey: String?,
    @SerializedName("product_categorey_old")
    var productCategoreyOld: Int,
    @SerializedName("product_rate")
    var productRate: String?,
    @SerializedName("product_status")
    var productStatus: String?,
    @SerializedName("product_type")
    var productType: String?,
    @SerializedName("product_unit")
    var productUnit: String?,
    @SerializedName("purchase_description")
    var purchaseDescription: String?,
    @SerializedName("purchase_inventory_status")
    var purchaseInventoryStatus: String?,
    @SerializedName("purchase_rate")
    var purchaseRate: String?,
    @SerializedName("purchase_status")
    var purchaseStatus: String?,
    @SerializedName("raw_materail_status")
    var rawMaterailStatus: String?,
    @SerializedName("reorder_level")
    var reorderLevel: String?,
    @SerializedName("reorder_level_quantity")
    var reorderLevelQuantity: String?,
    @SerializedName("sales_inventory_status")
    var salesInventoryStatus: String?,
    @SerializedName("sku")
    var sku: String?,
    @SerializedName("tax_rate")
    var taxRate: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("track_inventory_status")
    var trackInventoryStatus: String?,
    @SerializedName("unit_id")
    var unitId: String?,
    @SerializedName("user_id")
    var userId: String
)