package io;

/**
 * The ANTLR grammar used for linguistic definition.
 * Both grammar types define document, section and paragraph settings.
 * PHRASE_CREATOR uses phrase specifications; WRITER uses sentences and clauses etc.
 */
public enum AntlrGrammar
{
	PHRASE_CREATOR, WRITER,
}
