
case class OrderDiscount(value: BigDecimal, couponType: String, name: String, code: String)
case class OrderViewTotals(subTotal: BigDecimal, shipping: BigDecimal, tax: BigDecimal, discount: OrderDiscount,
                           merchantDiscount: BigDecimal, additionalPrice: BigDecimal, total: BigDecimal)
case class PiiToken(value: String, algo: Option[String])
case class AddressesTokens(shippingAddressToken: Option[PiiToken], billingAddressToken: Option[PiiToken],
                           pickupAddressToken: Option[PiiToken])
case class CartMedia(url: String, mediaType: String, width: Int, height: Int, altText: Option[String])
case class Media(fileId: String, fileType: String, link: String, time: Option[Long])
case class OrderItem(
                      productId: String,
                      name: String,
                      productType: String,
                      mediaItems: Set[Media],
                      optionsSelections: Seq[Int],
                      optionsSelectionsValues: Seq[(Int, String, String)],
                      quantity: Int,
                      price: BigDecimal,
                      totalPrice: BigDecimal,
                      media: CartMedia,
                      sku: String,
                      weight: Option[BigDecimal],
                      translatedName: Option[String]
                    )
case class CustomAmountDetailedItem(amount: BigDecimal, name: Option[String], quantity: Int, notes: Option[String])
case class Order(
                  createdDate: Long,
                  createdDate1: Long,
                  isNew: Boolean,
                  isNew1: Boolean,
                  currency: String,
                  currency1: String,
                  totals: OrderViewTotals,
                  addressesTokens: Option[AddressesTokens],
                  buyerNote: Option[String],
                  buyerId: Option[String],
                  svSession: Option[String],
                  status: String,
                  weight: BigDecimal,
                  weightUnit: String,
                  customAmountDetailedItems: Seq[CustomAmountDetailedItem],
                  items: Seq[OrderItem],
                  customAmountItems: Seq[BigDecimal],
                  shipments: Seq[String],
                  storeId: String,
                  installments: String,
                  isOrderArchived: Boolean,
                  previewMedia: CartMedia,
                  contactId: Option[String]
                )


object Main {
  import boopickle.shapeless.Default._
  def serialize(value: Order): java.nio.ByteBuffer = Pickle.intoBytes(value)
}