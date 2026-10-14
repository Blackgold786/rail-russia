// -- -- -- -- -- -- -- 
// by weikton x reytiz
// -- -- -- -- -- -- --
#include "CNetwork.h"
#include <stdint.h>

#include "util/CJavaWrapper.h"

const char* g_szServerNames[MAX_SERVERS] = {
	"VISKI SLIV INVENTORY REYTIZ | RED",
	"VISKI SLIV INVENTORY REYTIZ | TEST"
};

const CSetServer::CServerInstanceEncrypted g_sEncryptedAddresses[MAX_SERVERS] = {
	CSetServer::create("164.132.219.35", 1, 16, 2297, false),
	CSetServer::create("164.132.219.35", 1, 16, 2297, false)	
};