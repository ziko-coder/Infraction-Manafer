import { OwnerDetails } from "./ownerDetails.model";


export interface Vehicle{
  id : number;
  registrationNumber : string
  brand :string
  fiscalPower : string
  model : string
  owner : any
}
